package com.kafkastreams.movieservice.command.action;

import com.kafkastreams.movieservice.api.request.AddTagReq;
import com.kafkastreams.movieservice.entity.TagEntity;
import com.kafkastreams.movieservice.exception.ResourceNotFoundException;
import com.kafkastreams.movieservice.repository.TagRepository;
import com.kafkastreams.movieservice.util.entityMapper.TagEntityMapper;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@AllArgsConstructor
@NoArgsConstructor
@Component
public class TagCommandAction {

    private TagRepository tagRepository;
    private TagEntityMapper tagEntityMapper;

    public TagEntity save(AddTagReq newTag) {
        TagEntity tag = tagRepository.save(tagEntityMapper.toEntity(newTag.getName()));
        return tag;
    }

    public TagEntity update(int tagId, AddTagReq newTag) {
        Optional<TagEntity> tag = tagRepository.findById(tagId);
        if (!tag.isPresent()) {
            throw new ResourceNotFoundException("tag with id: " + tagId + " not found " );
        }
        TagEntity tagEntity = tag.get();
        tagEntity.setName(newTag.getName());
        TagEntity updateTag= tagRepository.save(tagEntity);
        return updateTag;
    }


    public TagEntity findById(int tagId) {
        return tagRepository.findById(tagId).get();
    }
}
