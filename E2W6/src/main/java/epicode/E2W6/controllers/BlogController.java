package epicode.E2W6.controllers;

import epicode.E2W6.entities.Blog;
import epicode.E2W6.payloads.NewBlogPayload;
import epicode.E2W6.services.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blogs")
public class BlogController {
    @Autowired
    private BlogService blogService;

    @GetMapping
    public List<Blog> getBlogs() {
        return this.blogService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Blog createBlog(@RequestBody NewBlogPayload body) {
        return this.blogService.saveBlog(body);
    }

    @GetMapping("/{blogId}")
    public Blog findBlogById(@PathVariable int blogId) {
        return this.blogService.findById(blogId);

    }
    @PutMapping("/{blogId}")
    public Blog findBlogByIdAndUpdate(@PathVariable int blogId, @RequestBody NewBlogPayload body){
        return this.blogService.findByIdAndUpdate(blogId, body);
    }


}