package com.app.core.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="job1")
public class PowerInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int 序号;
    private String 厂站名;
    private String 分支线路名称;
    private String 项目名称;
    private String 工作内容;
    private String 任务来源;
    private String 计划性质;
    private String 工作类型;
    private String 专业;
    private String 工作班组;
    private String 工作地点;
    private String 计划开始停电时间;
    private String 计划开工时间;
    private String 计划完工时间;
    private String 计划复电结束时间;
    private String 工作方式;
    private String 巡视小类;
    private String 定检小类;
    private String 电压等级;
    private String 影响;
    private String 停电影响范围;
    private String 影响负荷;
    private String 停电影响用户数;
    private String 停电影响台变数;
    private String 重要用户;
    private String 停电持续时间;
    private String 转供电情况;
    private String 作业责任单位;
    private String 作业单位;
    private String 风险;
    private String 等级;
    private String 管控层级;
    private String 管控;
    private String 方式;
    private String 验收;
    private String 层级;
    private String 作业文件;
    private String AI;
    private String AJ;
    private String AK;
    private String AL;
    private String 备注;



    public int get序号() {
        return 序号;
    }

    public void set序号(int 序号) {
        this.序号 = 序号;
    }

    public String get厂站名() {
        return 厂站名;
    }

    public void set厂站名(String 厂站名) {
        this.厂站名 = 厂站名;
    }

    public String get分支线路名称() {
        return 分支线路名称;
    }

    public void set分支线路名称(String 分支线路名称) {
        this.分支线路名称 = 分支线路名称;
    }

    public String get项目名称() {
        return 项目名称;
    }

    public void set项目名称(String 项目名称) {
        this.项目名称 = 项目名称;
    }

    public String get工作内容() {
        return 工作内容;
    }

    public void set工作内容(String 工作内容) {
        this.工作内容 = 工作内容;
    }

    public String get任务来源() {
        return 任务来源;
    }

    public void set任务来源(String 任务来源) {
        this.任务来源 = 任务来源;
    }

    public String get计划性质() {
        return 计划性质;
    }

    public void set计划性质(String 计划性质) {
        this.计划性质 = 计划性质;
    }

    public String get工作类型() {
        return 工作类型;
    }

    public void set工作类型(String 工作类型) {
        this.工作类型 = 工作类型;
    }

    public String get专业() {
        return 专业;
    }

    public void set专业(String 专业) {
        this.专业 = 专业;
    }

    public String get工作班组() {
        return 工作班组;
    }

    public void set工作班组(String 工作班组) {
        this.工作班组 = 工作班组;
    }

    public String get工作地点() {
        return 工作地点;
    }

    public void set工作地点(String 工作地点) {
        this.工作地点 = 工作地点;
    }

    public String get计划开始停电时间() {
        return 计划开始停电时间;
    }

    public void set计划开始停电时间(String 计划开始停电时间) {
        this.计划开始停电时间 = 计划开始停电时间;
    }

    public String get计划开工时间() {
        return 计划开工时间;
    }

    public void set计划开工时间(String 计划开工时间) {
        this.计划开工时间 = 计划开工时间;
    }

    public String get计划完工时间() {
        return 计划完工时间;
    }

    public void set计划完工时间(String 计划完工时间) {
        this.计划完工时间 = 计划完工时间;
    }

    public String get计划复电结束时间() {
        return 计划复电结束时间;
    }

    public void set计划复电结束时间(String 计划复电结束时间) {
        this.计划复电结束时间 = 计划复电结束时间;
    }

    public String get工作方式() {
        return 工作方式;
    }

    public void set工作方式(String 工作方式) {
        this.工作方式 = 工作方式;
    }

    public String get巡视小类() {
        return 巡视小类;
    }

    public void set巡视小类(String 巡视小类) {
        this.巡视小类 = 巡视小类;
    }

    public String get定检小类() {
        return 定检小类;
    }

    public void set定检小类(String 定检小类) {
        this.定检小类 = 定检小类;
    }

    public String get电压等级() {
        return 电压等级;
    }

    public void set电压等级(String 电压等级) {
        this.电压等级 = 电压等级;
    }

    public String get影响() {
        return 影响;
    }

    public void set影响(String 影响) {
        this.影响 = 影响;
    }

    public String get停电影响范围() {
        return 停电影响范围;
    }

    public void set停电影响范围(String 停电影响范围) {
        this.停电影响范围 = 停电影响范围;
    }

    public String get影响负荷() {
        return 影响负荷;
    }

    public void set影响负荷(String 影响负荷) {
        this.影响负荷 = 影响负荷;
    }

    public String get停电影响用户数() {
        return 停电影响用户数;
    }

    public void set停电影响用户数(String 停电影响用户数) {
        this.停电影响用户数 = 停电影响用户数;
    }

    public String get停电影响台变数() {
        return 停电影响台变数;
    }

    public void set停电影响台变数(String 停电影响台变数) {
        this.停电影响台变数 = 停电影响台变数;
    }

    public String get重要用户() {
        return 重要用户;
    }

    public void set重要用户(String 重要用户) {
        this.重要用户 = 重要用户;
    }

    public String get停电持续时间() {
        return 停电持续时间;
    }

    public void set停电持续时间(String 停电持续时间) {
        this.停电持续时间 = 停电持续时间;
    }

    public String get转供电情况() {
        return 转供电情况;
    }

    public void set转供电情况(String 转供电情况) {
        this.转供电情况 = 转供电情况;
    }

    public String get作业责任单位() {
        return 作业责任单位;
    }

    public void set作业责任单位(String 作业责任单位) {
        this.作业责任单位 = 作业责任单位;
    }

    public String get作业单位() {
        return 作业单位;
    }

    public void set作业单位(String 作业单位) {
        this.作业单位 = 作业单位;
    }

    public String get风险() {
        return 风险;
    }

    public void set风险(String 风险) {
        this.风险 = 风险;
    }

    public String get等级() {
        return 等级;
    }

    public void set等级(String 等级) {
        this.等级 = 等级;
    }

    public String get管控层级() {
        return 管控层级;
    }

    public void set管控层级(String 管控层级) {
        this.管控层级 = 管控层级;
    }

    public String get管控() {
        return 管控;
    }

    public void set管控(String 管控) {
        this.管控 = 管控;
    }

    public String get方式() {
        return 方式;
    }

    public void set方式(String 方式) {
        this.方式 = 方式;
    }

    public String get验收() {
        return 验收;
    }

    public void set验收(String 验收) {
        this.验收 = 验收;
    }

    public String get层级() {
        return 层级;
    }

    public void set层级(String 层级) {
        this.层级 = 层级;
    }

    public String get作业文件() {
        return 作业文件;
    }

    public void set作业文件(String 作业文件) {
        this.作业文件 = 作业文件;
    }

    public String getAI() {
        return AI;
    }

    public void setAI(String AI) {
        this.AI = AI;
    }

    public String getAJ() {
        return AJ;
    }

    public void setAJ(String AJ) {
        this.AJ = AJ;
    }

    public String getAK() {
        return AK;
    }

    public void setAK(String AK) {
        this.AK = AK;
    }

    public String getAL() {
        return AL;
    }

    public void setAL(String AL) {
        this.AL = AL;
    }

    public String get备注() {
        return 备注;
    }

    public void set备注(String 备注) {
        this.备注 = 备注;
    }
}
