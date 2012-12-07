package org.springframework.social.fivepx.api;

import org.springframework.social.ApiBinding;

public interface Fivepx extends ApiBinding {

	BlogOperations blogOperations();

	CollectionOperations collectionOperations();

	PhotoOperations photoOperations();

	UploadOperations uploadOperations();

	UserOperations userOperations();

}
