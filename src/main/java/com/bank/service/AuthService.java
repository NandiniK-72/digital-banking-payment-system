package com.bank.service;

import com.bank.dto.LoginRequestDTO;
import com.bank.dto.RegisterRequestDTO;

public interface AuthService {

    String register(RegisterRequestDTO request);

    String login(LoginRequestDTO request);

}
