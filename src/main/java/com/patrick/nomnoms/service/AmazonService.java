package com.patrick.nomnoms.service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.S3Object;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;

@Component
public class AmazonService {

    private static final Logger log = LoggerFactory.getLogger(AmazonService.class);

    @Autowired
    private AmazonS3 amazonS3Client;

    @Value("${aws.accountId}")
    private String accountId;

    public void putObject(String bucketName, String fileKey, File file) {
        try {
            log.info("Saving file {}/{}", bucketName, fileKey);
            amazonS3Client.putObject(getBucketPrefix(bucketName), fileKey, file);
        } catch (Exception e) {
            log.error("Could not save to {}/{}", getBucketPrefix(bucketName), fileKey);
        }
    }

    public void putObject(String bucketName, String fileKey, String file) {
        try {
            log.info("Saving file {}/{}", bucketName, fileKey);
            amazonS3Client.putObject(getBucketPrefix(bucketName), fileKey, file);
        } catch (Exception e) {
            log.error("Could not save to {}/{}", getBucketPrefix(bucketName), fileKey, e);
        }
    }

    public S3Object getObject(String bucketName, String fileKey) {
        try {
            return amazonS3Client.getObject(getBucketPrefix(bucketName), fileKey);
        } catch (Exception e) {
            log.error("Could not retrieve file", e);
        }
        return null;
    }


    public String getBucketPrefix(String bucketName) {
        return accountId + "-" + bucketName;
    }
}
