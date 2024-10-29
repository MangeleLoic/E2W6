package epicode.E2W6.services;

import epicode.E2W6.entities.Blog;
import epicode.E2W6.payloads.NewBlogPayload;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class BlogService {
    private List<Blog> blogsList = new ArrayList<>();

    public List<Blog> findAll() {
        return this.blogsList;
    }
    public Blog saveBlog(NewBlogPayload body){
        Random random = new Random();
        Blog newBlog = new Blog(body.getCategoria(), body.getContenuto(), body.getCover(), body.getTempoDiLettura(), body.getTitolo());
        newBlog.setId(random.nextInt(111,999));
        this.blogsList.add(newBlog);
        return newBlog;
    }

    public Blog findById(int blogId) {

        for (Blog blog : this.blogsList) {
            if (blog.getId() == blogId) {
                return blog;
            }
        }
        return null;
    }

    public Blog findByIdAndUpdate(int blogId, NewBlogPayload body) {
        for (Blog blog : this.blogsList) {
            if (blog.getId() == blogId) {
                blog.setCategoria(body.getCategoria());
                blog.setTitolo(body.getTitolo());
                blog.setCover(body.getCover());
                blog.setContenuto(body.getContenuto());
                blog.setTempoDiLettura(body.getTempoDiLettura());
                return blog;
            }
        }
        return null;

    }


}
