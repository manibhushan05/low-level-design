package com.apexviz.couponservice.controllers;

import com.apexviz.couponservice.payloads.requests.CouponRequest;
import com.apexviz.couponservice.payloads.responses.CouponResponse;
import com.apexviz.couponservice.services.CouponService;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@Slf4j
@RequestMapping(path = "/api/v1/coupons/", name = "Coupons controller")
@AllArgsConstructor
public class CouponController {
    private CouponService couponService;

    @GetMapping(path = "")
    public ResponseEntity<?> getCoupons() {
        return ResponseEntity.ok(couponService.index());
    }

    @PostMapping(path = "")
    public ResponseEntity<?> createCoupon(@Valid @NonNull @RequestBody CouponRequest couponRequest) {
        CouponResponse couponResponse = couponService.create(couponRequest);
        return ResponseEntity.ok(couponResponse);
    }
}
