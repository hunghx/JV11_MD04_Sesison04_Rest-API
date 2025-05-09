package ra.api.service;

import ra.api.model.dto.response.UserResponseDto;

public interface IAdminService {
    UserResponseDto addRoleToUser(Long userId, Long roleId);
}
