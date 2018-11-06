package com.app.core.service;

import com.app.core.domain.FileManage;
import com.app.core.domain.FileManageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * 附件管理接口实现类
 */
@Service
public class FileManageServiceImpl implements FileManageService {

    @Autowired
    FileManageRepository fileManageRepository;
    @Override
    public List<FileManage> findByInfoId(int InfoId) {
        return fileManageRepository.findByInfoId(InfoId);
    }


    @Override
    @Transactional
    public void save(FileManage f) {
        fileManageRepository.save(f);
    }

    @Override
    public Optional<FileManage> findById(int id) {
        return fileManageRepository.findById(id);
    }

    @Override
    public void delFile(int id) {
        fileManageRepository.deleteById(id);
    }


}
