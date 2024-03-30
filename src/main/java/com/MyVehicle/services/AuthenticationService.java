package com.MyVehicle.services;

import com.MyVehicle.dto.JWTAuthenticationResponse;
import com.MyVehicle.dto.RefreshTokenRequest;
import com.MyVehicle.dto.SignInRequest;
import com.MyVehicle.dto.SignUpRequest;
import com.MyVehicle.models.User;

public interface AuthenticationService {
	User signUp(SignUpRequest signUpRequest);
	
	JWTAuthenticationResponse signin(SignInRequest signInRequest);
	JWTAuthenticationResponse refreshToken(RefreshTokenRequest refreshTokenRequest);

}
