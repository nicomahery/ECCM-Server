package fr.hiapoe.eccmserver.eccmserver.services;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;

@Service
public class S3Service {
    static final int RETRY_COUNT = 10;
    private AmazonS3 s3;
    @Value("${s3.bucket.location}")
    private String s3Endpoint;
    @Value("${s3.bucket.access-key}")
    private String accessKey;
    @Value("${s3.bucket.secret-key}")
    private String secretKey;
    @Value("${s3.bucket.name}")
    private String bucketName;
    @Value("${s3.bucket.region}")
    private String region;

    @PostConstruct
    public void connectToBucket() {
        AWSCredentials credentials = new BasicAWSCredentials(accessKey, secretKey);
        this.s3 = AmazonS3ClientBuilder
                .standard()
                .withCredentials(new AWSStaticCredentialsProvider((credentials)))
                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(s3Endpoint, this.region))
                .build();
    }

    private String getObjectKeyFromObjectLocation(String objectLocation) {
        if (objectLocation.contains(this.getS3Location())) {
            return objectLocation.replaceAll(this.getS3Location(), "");
        }
        while (objectLocation.startsWith("/")) {
            objectLocation = objectLocation.substring(1);
        }
        return objectLocation;
    }

    public byte[] getObject(String objectLocation) throws IOException {
        S3Object s3Object = this.s3.getObject(new GetObjectRequest(this.bucketName,
                this.getObjectKeyFromObjectLocation(objectLocation)));
        byte[] bytes = s3Object.getObjectContent().readAllBytes();
        s3Object.close();
        return bytes;
    }

    public String getS3Location() {
        return String.format("https://%s/%s/", this.s3Endpoint, this.bucketName);
    }

    public void deleteObject(String objectLocation) {
        this.s3.deleteObject(this.bucketName, this.getObjectKeyFromObjectLocation(objectLocation));
    }
}
