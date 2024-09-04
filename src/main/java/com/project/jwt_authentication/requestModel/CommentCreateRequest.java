package com.project.jwt_authentication.requestModel;

import lombok.Data;

@Data
public class CommentCreateRequest {
Long id;
Long post_id;
Long user_id;
String text;
}
