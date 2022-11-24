/*
 * Author Name : M.Krishna.
 * Date: 24-11-2022
 * Created With: IntelliJ IDEA Community Edition
 *
 */


package com.niit.jdp.BEJ_C2_S3_REST_API_MONGODB_PC_1.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT, reason = "Customer with Specific Id already Exits,TryOtherId")
public class CustomerAlreadyExists extends Exception {
}
