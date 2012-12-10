package org.springframework.social.fivepx.api;

import java.util.List;

/**
 * @author Daniel Rochetti
 */
public interface BlogOperations {

	List<BlogPostComment> getComments(Long blogId);

}
