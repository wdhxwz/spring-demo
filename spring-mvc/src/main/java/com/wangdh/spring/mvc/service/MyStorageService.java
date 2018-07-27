package com.wangdh.spring.mvc.service;

import com.krista.extend.mvc.upload.StorageService;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.stream.Stream;

@Service("myStorageService")
public class MyStorageService implements StorageService{
    @Override
    public void init() {

    }

    @Override
    public Object store(MultipartFile multipartFile) {
        return "我不做处理的";
    }

    @Override
    public Stream<Path> loadAll() {
        return null;
    }

    @Override
    public Path load(String s) {
        return null;
    }

    @Override
    public Resource loadAsResource(String s) {
        return null;
    }

    @Override
    public void deleteAll() {

    }
}
