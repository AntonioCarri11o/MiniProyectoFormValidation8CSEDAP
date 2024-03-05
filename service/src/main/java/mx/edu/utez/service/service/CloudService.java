package mx.edu.utez.service.service;

import com.google.cloud.storage.Blob;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class CloudService {
    private final Storage storage;
    private final String bucketName = "form-bucket";

    public static final String CLOUD_URL = "https://storage.googleapis.com/";

    public CloudService() {
        storage = StorageOptions.getDefaultInstance().getService();
    }

    public String saveFile(MultipartFile file) throws IOException {
        byte [] content = file.getBytes();
        String fileName = file.getOriginalFilename();
        Blob blob = storage.create(BlobInfo.newBuilder(bucketName, fileName).build(), content);
        return CLOUD_URL + bucketName + '/' + fileName;
    }
}
