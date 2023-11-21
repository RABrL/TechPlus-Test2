package com.example.back.domain.usecase;

import com.example.back.domain.api.ICommentServicePort;
import com.example.back.domain.exception.NoDataFoundException;
import com.example.back.domain.model.Comment;
import com.example.back.domain.spi.ICommentPersistencePort;
import com.example.back.domain.spi.IQueryPersistencePort;
import com.example.back.domain.spi.IUserPersistencePort;

import java.util.List;

public class CommentUseCase implements ICommentServicePort {
    private final ICommentPersistencePort commentPersistencePort;
    private final IUserPersistencePort userPersistencePort;
    private final IQueryPersistencePort queryPersistencePort;

    public CommentUseCase(
            ICommentPersistencePort commentPersistencePort,
            IUserPersistencePort userPersistencePort,
            IQueryPersistencePort queryPersistencePort) {
        this.commentPersistencePort = commentPersistencePort;
        this.userPersistencePort = userPersistencePort;
        this.queryPersistencePort = queryPersistencePort;
    }

    @Override
    public void saveComment(Comment comment) {
        userPersistencePort.getUserById(comment.getUser().getId()); // throws UserNotFoundException
        queryPersistencePort.getQueryById(comment.getQueryId()); // throws QueryNotFoundException
        commentPersistencePort.saveComment(comment);
    }

    @Override
    public List<Comment> getAllComments() {
        List<Comment> commentList = commentPersistencePort.getAllComments();
        if(commentList.isEmpty()) throw new NoDataFoundException("No comments found");
        return commentList;
    }

    @Override
    public Comment getCommentById(Long id) {
        return commentPersistencePort.getCommentById(id);
    }
}
