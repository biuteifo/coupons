package com.alex.core.order;

import com.alex.RestServerException;

/**
 * rebate-alliance OrderArgumentsException
 * Created by 2019-02-26
 *
 * @author Alex bob(https://github.com/vnobo)
 */
public class OrderArgumentsException extends RestServerException {

    public OrderArgumentsException(int code, String msg) {
        super(code, msg);
    }
}
