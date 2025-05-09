package ra.api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ra.api.model.dto.response.UserResponseDto;
import ra.api.service.IAdminService;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {
    private final IAdminService adminService;
    @PostMapping("/users/{userId}/role/{roleId}")
    public ResponseEntity<?> addRoleToUser(@PathVariable Long userId, @PathVariable Long roleId){
        UserResponseDto dto = adminService.addRoleToUser(userId, roleId);
        Map<String , UserResponseDto> map = new HashMap<>();
        map.put("data", dto);
        return new ResponseEntity<>(map, HttpStatus.OK);
    }

}
