package org.iclass.myboard.controller;

import org.iclass.myboard.dto.CommunityDto;
import org.iclass.myboard.dto.UserDto;
import org.iclass.myboard.mapper.CommunityMapper;
import org.iclass.myboard.mapper.UserMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@AllArgsConstructor
public class CommunityController {
    private CommunityMapper communityMapper;
    private UserMapper userMapper;

    @GetMapping("/")
    public String searchAll(Model model) {
        model.addAttribute("cList", communityMapper.selectAll());
        return "index";
    }

    @GetMapping("/content")
    public String searchContent(@RequestParam int idx, Model model) {
        model.addAttribute("cList", communityMapper.selectByPk(idx));
        return "content";
    }

    @GetMapping("/input")
    public String input() {
        return "write";
    }

    @PostMapping("/")
    public String input(Model model, CommunityDto dto, UserDto udto) {
        if (userMapper.selectUser(udto) != null)
            communityMapper.insertCommunity(dto);
        else {
            System.out.println("없습니다.");
        }
        model.addAttribute("cList", communityMapper.selectAll());
        return "index";
    }

    @DeleteMapping("/")
    public String deleteCommunity(@RequestParam int idx, Model model) {
        communityMapper.deleteCommunity(idx);
        model.addAttribute("cList", communityMapper.selectAll());
        return "index";
    }

}
