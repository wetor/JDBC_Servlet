package service;

public interface  PostService {
    /**
     * 发帖
     * @param title title
     * @param author author
     * @param content content
     * @return boolean
     */
    public boolean posting(String title,String author,String content);
    /**
     * @param id id
     * @return boolean
     */
    public boolean delete(int id);

}
