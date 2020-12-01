package ru.naumow.project;

import lombok.SneakyThrows;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import ru.naumow.project.controllers.BlogController;
import ru.naumow.project.domain.Blog;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class CoursesRepresentationProcessor implements RepresentationModelProcessor<EntityModel<Blog>> {

    @SneakyThrows
    @Override
    public EntityModel<Blog> process(EntityModel<Blog> model) {
        Blog blog = model.getContent();
        if (blog != null) {
            Link getPostsForAccount = linkTo(methodOn(BlogController.class).getBlogPosts(model.getContent().getId(), null))
                    .withRel("posts-for-account");
            Link subscribe = linkTo(methodOn(BlogController.class).subscribe(blog.getId(), null))
                    .withRel("subscribe");

            model.add(getPostsForAccount, subscribe);
        }
        return model;
    }

}
