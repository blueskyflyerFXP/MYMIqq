package entity;

import interfaces.Translate;
import myutils.ObjectTranslate;

import java.io.Serializable;

/**
 * 传输实体
 * 用于在网络中传输数据
 */
public class TransmitInfo implements Translate, Serializable {
    //发送方信息
    private ChangeInfo form;
    //接收方信息
    private ChangeInfo to;
    //功能码，用于识别发送的意图
    private Integer functionCode;
    //传输类型：传输的数据的类型
    private String transmitType;
    //传输的数据
    private Object transmitContent;

    public TransmitInfo() {
    }

    public TransmitInfo(ChangeInfo form, ChangeInfo to, Integer functionCode, String transmitType, Object transmitContent) {
        this.form = form;
        this.to = to;
        this.functionCode = functionCode;
        this.transmitType = transmitType;
        this.transmitContent = transmitContent;

    }

    public ChangeInfo getForm() {
        return form;
    }

    public void setForm(ChangeInfo form) {
        this.form = form;
    }

    public ChangeInfo getTo() {
        return to;
    }

    public void setTo(ChangeInfo to) {
        this.to = to;
    }

    public Integer getFunctionCode() {
        return functionCode;
    }

    public void setFunctionCode(Integer functionCode) {
        this.functionCode = functionCode;
    }

    public String getTransmitType() {
        return transmitType;
    }

    public void setTransmitType(String transmitType) {
        this.transmitType = transmitType;
    }

    public Object getTransmitContent() {
        return transmitContent;
    }

    public void setTransmitContent(Object transmitContent) {
        this.transmitContent = transmitContent;
    }

    @Override
    public String toString() {
        return "TransmitInfo{" +
                "form=" + form +
                ", to=" + to +
                ", functionCode=" + functionCode +
                ", transmitType='" + transmitType + '\'' +
                ", transmitContent=" + transmitContent +
                '}';
    }

    @Override
    public byte[] ObjectToByte() {
        return ObjectTranslate.ObjectToByte(this);
    }

    @Override
    public TransmitInfo ByteToObject(byte[] bytes) {
        return (TransmitInfo)ObjectTranslate.ByteToObject(bytes);
    }
}
