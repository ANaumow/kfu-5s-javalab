package ru.naumow.project.controllers;

import lombok.SneakyThrows;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import ru.naumow.project.domain.Blog;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class PostProcessor implements RepresentationModelProcessor<EntityModel<Blog>> {


    @Override
    public EntityModel<Blog> process(EntityModel<Blog> model) {
        return model;
    }

}
