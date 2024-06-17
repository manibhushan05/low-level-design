package com.apexviz.couponservice.services.impl;

import com.apexviz.couponservice.entities.Coupon;
import com.apexviz.couponservice.payloads.requests.CouponRequest;
import com.apexviz.couponservice.payloads.responses.CouponResponse;
import com.apexviz.couponservice.repositories.CouponRepository;
import com.apexviz.couponservice.services.CouponService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Setter
@Getter
@AllArgsConstructor
@Slf4j
public class CouponServiceImpl implements CouponService {
    private CouponRepository couponRepository;

    @Override
    public List<CouponResponse> index() {
        List<Coupon> coupons = couponRepository.findAll();
        return coupons.stream().map(this::convertToCouponResponse).collect(Collectors.toList());
    }

    @Override
    public CouponResponse create(CouponRequest request) {
        Coupon coupon = new Coupon();
        coupon.setCode(request.getCode());
        couponRepository.save(coupon);
        return convertToCouponResponse(coupon);
    }

    private CouponResponse convertToCouponResponse(Coupon coupon) {
        CouponResponse couponResponse = new CouponResponse();
        couponResponse.setId(coupon.getId());
        couponResponse.setCode(coupon.getCode());
        return couponResponse;
    }
}
