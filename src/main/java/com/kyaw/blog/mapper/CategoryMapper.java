package com.kyaw.blog.mapper;

import com.kyaw.blog.domain.dto.CategoryDto;
import com.kyaw.blog.domain.entity.Category;
import com.kyaw.blog.domain.entity.Post;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CategoryMapper {

    @Mapping(target = "postCount", source = "posts", qualifiedByName = "calculatePostCount")
    CategoryDto toDto(Category category);

    @Named("calculatePostCount")
    default long calculatePostCount(List<Post> posts) {
        return posts == null ? 0 : posts.stream().filter(post -> post != null).count();
    }
}
