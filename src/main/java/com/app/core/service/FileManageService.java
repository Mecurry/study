package com.app.core.service;

import com.app.core.domain.FileManage;

import java.util.List;
import java.util.Optional;

/**
 * 附件管理业务接口
 */
public interface FileManageService {
    List<FileManage> findByInfoId(int  InfoId);
    void save(FileManage f);
    Optional<FileManage> findById(int id);
    void delFile(int id);

}
