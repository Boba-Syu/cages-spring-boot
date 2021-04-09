package cn.bobasyu.cagesspringboot.controller;

import cn.bobasyu.cagesspringboot.service.InstructionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 发送指令到下位机的web RESTFul API
 *
 * @author bobasyu
 */
@RestController
@RequestMapping("/api")
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
