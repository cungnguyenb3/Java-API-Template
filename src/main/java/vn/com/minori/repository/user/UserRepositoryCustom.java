package vn.com.minori.repository.user;

import vn.com.minori.domain.User;

import java.util.List;

public interface UserRepositoryCustom {
    List<User> search(String keyword);
}
