package cn.bobasyu.cagesspringboot.controller;

import cn.bobasyu.cagesspringboot.service.InstructionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 发送指令到下位机的web RESTFul API
 *
 * @author bobasyu
 */
@RestController
@RequestMapping("/api")
@CrossOrigin
public class InstructionController {
    private final InstructionService instructionService;

    @Autowired
    public InstructionController(InstructionService instructionService) {
        this.instructionService = instructionService;
    }

    @GetMapping("/instruction/{msg}")
    public int sendInstruction(@PathVariable String msg) {
        return instructionService.sendInstruction(msg);
    }
}
