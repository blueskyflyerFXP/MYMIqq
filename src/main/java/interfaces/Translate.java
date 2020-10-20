package interfaces;

public interface Translate {
    /**
     * 对象转byte
     */
    public  byte[] ObjectToByte();
    /**
     * byte转对象
     * @param bytes
     * @return
     */
    public Object ByteToObject(byte[] bytes);
}
