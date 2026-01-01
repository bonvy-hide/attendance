package com.gc.attendance.controller;

import com.gc.attendance.common.result.Result;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 考勤组 控制器
 *
 * @author attendance
 * @since 1.0.0
 */
@Tag(name = "考勤组管理", description = "考勤组管理接口")
@RestController
@RequestMapping("/attendance/group")
@RequiredArgsConstructor
public class GroupController {

//    private final GroupService groupService;

    @Operation(summary = "分页查询考勤组列表")
    @PostMapping("/page")
    public Result page() {
        return Result.success();
    }

}

