package com.alex.wx.core.Customer;

import com.alex.wx.BaseGenericService;
import com.alex.wx.core.Customer.beans.Customer;
import com.alex.wx.core.Customer.beans.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.Optional;
import java.util.concurrent.Future;

@Service
@RequiredArgsConstructor
public class CustomerService extends BaseGenericService {

    private final CustomerRepository customerRepository;

    /**
     * 判断微信用户是否存在
     *
     * @param openId 微信id
     * @return 存在为 tru,不存在为false
     */
    public boolean exists(String openId) {
        logger.debug("exists Customer  open id is " + openId);
        Customer customer = loadByOpenId(openId);
        return !ObjectUtils.isEmpty(customer);
    }

    public Customer loadByPid(String pid) {
        Optional<Customer> optionalCustomer = customerRepository.findByPid_AdZoneId(pid);
        return optionalCustomer.orElse(null);
    }

    public Customer loadByOpenId(String openId) {
        Optional<Customer> optionalCustomer = customerRepository.findByOpenId(openId);
        return optionalCustomer.orElse(null);
    }

}
