package com.qa.project_recipies.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.persistence.EntityNotFoundException;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "The recipe with this id doesn't exist")
public class RecipeNotFoundException extends EntityNotFoundException {
}
