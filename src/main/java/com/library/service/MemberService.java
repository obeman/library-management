package com.library.service;

import com.library.dto.MemberDTO;
import com.library.entity.Member;
import com.library.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    public MemberDTO createMember(MemberDTO memberDTO) {
        Member member = new Member();
        member.setName(memberDTO.getName());
        member.setEmail(memberDTO.getEmail());
        member.setPhone(memberDTO.getPhone());
        Member savedMember = memberRepository.save(member);
        return convertToDTO(savedMember);
    }

    public MemberDTO updateMember(Long id, MemberDTO memberDTO) {
        Member member = memberRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Member not found"));
        member.setName(memberDTO.getName());
        member.setEmail(memberDTO.getEmail());
        member.setPhone(memberDTO.getPhone());
        Member updatedMember = memberRepository.save(member);
        return convertToDTO(updatedMember);
    }

    public void deleteMember(Long id) {
        memberRepository.deleteById(id);
    }

    public List<MemberDTO> getAllMembers() {
        return memberRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public MemberDTO getMemberById(Long id) {
        Member member = memberRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Member not found"));
        return convertToDTO(member);
    }

    private MemberDTO convertToDTO(Member member) {
        MemberDTO dto = new MemberDTO();
        dto.setId(member.getId());
        dto.setName(member.getName());
        dto.setEmail(member.getEmail());
        dto.setPhone(member.getPhone());
        return dto;
    }
} 