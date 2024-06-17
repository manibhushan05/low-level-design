package com.apexviz.couponservice.services;

import com.apexviz.couponservice.payloads.requests.CouponRequest;
import com.apexviz.couponservice.payloads.responses.CouponResponse;

import java.util.List;


public interface CouponService {
    List<CouponResponse> index();

    CouponResponse create(CouponRequest request);
}
