package ru.naumow.project;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import ru.naumow.project.domain.Post;
import ru.naumow.project.services.BlogService;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.mockito.Mockito.when;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
@SpringBootTest
@AutoConfigureRestDocs(outputDir = "target/snippets")
public class BlogTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BlogService blogService;

    @BeforeEach
    public void setUp() {
        when(blogService.getPostsOfBlog(3L, 1L)).thenReturn(targetPosts());
    }

    @Test
    public void gettingPosts() throws Exception {
        mockMvc.perform(get("/blogs/3/posts-for-account?account-id=1")).andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$._embedded.posts[0].text").value("post4"))
                .andExpect(jsonPath("$._embedded.posts[1].text").value("post2"))
                .andDo(document("getting_posts", responseFields(
                        fieldWithPath("_embedded.posts[0].text").description("Текст поста 1"),
                        fieldWithPath("_embedded.posts[1].text").description("Текст поста 2")
                )));
    }

    private Set<Post> targetPosts() {
        return new HashSet<>(Arrays.asList(
                Post.builder()
                        .text("post4")
                        .build(),
                Post.builder()
                        .text("post2")
                        .build()
        ));
    }
}
