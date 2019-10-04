package com.company.SandyYeungU1Capstone.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class PasswordConfig {

    public static void main(String[] args) {
        PasswordEncoder enc = new BCryptPasswordEncoder();

        String password = "public";

        String encodedPassword = enc.encode(password);

        System.out.println(encodedPassword);
    }
}

//staff -- 'staff' || $2a$10$LwgIEXoD7l/OUBv9JMH74uP90vAn5GlNed0c1yMXVm5uRmdRSpYB6
//manager -- 'manager' || $2a$10$syku.CrcJ9tA5ZtHGOoZauGqkY68Jp0Ve1OwmBghzqbFeVB1HC02y
//admin -- 'admin' || $2a$10$z0SyfHc56ZmlxBoVLt2MNOP2o3Rvm7O5NdrNm7Y5uwHgBCJNj4cF6
//public -- 'public' || $2a$10$t9ea953X4TrFKQp28zCNq.fkFUld0PcgyoKUN6uXWaD/h93q.4Bhq

