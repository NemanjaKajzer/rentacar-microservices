package com.AthorizationAndAuthentication.AthorizationAndAuthentication.service;

import com.AthorizationAndAuthentication.AthorizationAndAuthentication.model.Agent;
import com.AthorizationAndAuthentication.AthorizationAndAuthentication.repository.AgentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AgentService {

    @Autowired
    private AgentRepository agentRepository;

    public Long getAgentIDByEmail(String email){
        Agent agent = agentRepository.findByUser_LoginInfo_Email(email);

        return agent.getId();
    }

    // public boolean checkPasswordChanged(){
    //     ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder
    //             .currentRequestAttributes();
    //     HttpSession session = attr.getRequest().getSession(true);
    //     Long id = (Long) session.getAttribute("user");

    //     Optional opt = agentRepository.findById(id);
    //     if(opt.isPresent()){
    //         Agent agent = (Agent) opt.get();
    //         return agent.isFirst_login() ? false : true;
    //     }

    //     return false;
    // }
    
    public Long getAgentIDByUserID(Long id){
        Agent agent = agentRepository.findByUser_Id(id);

        return agent.getId();
    }

    public String getAgentMail(Long id){
        Agent agent = agentRepository.findOneById(id);

        return agent.getUser().getLoginInfo().getEmail();
    }
}