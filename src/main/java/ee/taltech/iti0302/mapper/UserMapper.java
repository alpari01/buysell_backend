package ee.taltech.iti0302.mapper;

import ee.taltech.iti0302.dto.UserDto;
import ee.taltech.iti0302.models.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {

    UserDto toDto(User user);

    User dtoTo(UserDto userDto);

    List<UserDto> toDtoList(List<User> users);
}
