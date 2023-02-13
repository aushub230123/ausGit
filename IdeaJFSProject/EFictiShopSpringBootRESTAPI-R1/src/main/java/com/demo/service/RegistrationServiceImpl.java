package com.demo.service;

import com.demo.entity.Registration;
import com.demo.repository.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Service
public class RegistrationServiceImpl implements  RegistrationService{
    // Dependency Injection (spring framework creates the Repository internally and
    // injects the instance into your app
    @Autowired
    private RegistrationRepository registrationRepository;
    @Override
    public Registration save(Registration registration) {
        // SECURE THE PASSWORD AND STORE IN DB
        // if registration exists return error / null

//        This MessageDigest class provides applications the functionality of a message digest algorithm, such as SHA-1 or SHA-256. Message digests are secure one-way hash functions that take arbitrary-sized data and output a fixed-length hash value.
        MessageDigest messageDigest;
        try {
            messageDigest = MessageDigest.getInstance("MD5");
            byte[] passwordInBytes = registration.getPassword().getBytes();
            messageDigest.update(passwordInBytes);
            byte[] resultByteArray = messageDigest.digest();
            StringBuilder stringBuilder = new StringBuilder();
            for(byte byteVar : resultByteArray) {
                String formattedString = String.format("%02x", byteVar);
                stringBuilder.append(formattedString);
            }
            String hashedPassword = stringBuilder.toString();
            registration.setPassword(hashedPassword);
        } catch (NoSuchAlgorithmException e) {
            System.out.println("No Such Algorithm....");
//            rethrowing the exception
            throw new RuntimeException(e);
        }
        Registration savedRegistration = registrationRepository.save(registration);
        return  savedRegistration;
    }

    @Override
    public Registration findByEmail(String email) {
        return null;
    }

    @Override
    public Registration findByEmailAndPassword(String email, String password) {
        return registrationRepository.findByEmailAndPassword(email,password);
    }

    @Override
    public Boolean isValidUser(String email, String password) {
        MessageDigest messageDigest;
        try {
            messageDigest = MessageDigest.getInstance("MD5");
            byte[] passwordInBytes = password.getBytes();
            messageDigest.update(passwordInBytes);
            byte[] resultByteArray = messageDigest.digest();
            StringBuilder stringBuilder = new StringBuilder();
            for(byte byteVar : resultByteArray) {
                String formattedString = String.format("%02x", byteVar);
                stringBuilder.append(formattedString);
            }
            String hashedPassword = stringBuilder.toString();
           Registration registration = findByEmailAndPassword(email,hashedPassword);
           if(registration != null) {
               return true;
           }
        } catch (NoSuchAlgorithmException e) {
            System.out.println("No Such Algorithm....");
//            rethrowing the exception
            throw new RuntimeException(e);
        }
        return false;
    }
}
