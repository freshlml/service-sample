package com.xy.sample.rocketmq.cotroller;


import com.sc.common.vo.JsonResult;
import com.xy.sample.dto.scan.SampleScanAddDto;
import com.xy.sample.service.scan.SampleScanService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping("rmq")
public class RmqTestController {

    @Autowired
    private SampleScanService sampleScanService;

    @PostMapping("sampleTopicUpdate")
    public JsonResult sampleTopicUpdate(@RequestBody @Valid SampleScanAddDto scanDto) {
        sampleScanService.sampleTopicUpdate(scanDto);
        return JsonResult.buildSuccessResult("保存成功");
    }


    @PostMapping("txProducer")
    public JsonResult txProducer(@RequestBody @Valid SampleScanAddDto scanDto) {
        try {
            boolean result = sampleScanService.txProducer(scanDto);
            if(!result) return JsonResult.buildSuccessResult("error");
        } catch (Exception e) {
            return JsonResult.buildSuccessResult("error");
        }
        return JsonResult.buildSuccessResult("保存成功");
    }

    @PostMapping("txProducer2")
    public JsonResult txProducer2(@RequestBody @Valid SampleScanAddDto scanDto) {
        try {
            boolean result = sampleScanService.txProducer2(scanDto);
            if(!result) return JsonResult.buildSuccessResult("error");
        } catch (Exception e) {
            return JsonResult.buildSuccessResult("error");
        }
        return JsonResult.buildSuccessResult("保存成功");
    }


    @GetMapping("other")
    public JsonResult other() {
        sampleScanService.other();
        return JsonResult.buildSuccessResult("test成功");
    }

}