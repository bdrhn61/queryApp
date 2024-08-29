package com.project.question.requestModel;

import lombok.Data;

@Data
public class CommentCreateRequest {
Long id;
Long post_id;
Long user_id;
String text;
}
