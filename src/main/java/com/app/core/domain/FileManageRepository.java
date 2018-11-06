package com.app.core.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FileManageRepository extends JpaRepository<FileManage,Integer> {

    List<FileManage> findByInfoId(int id);
}
