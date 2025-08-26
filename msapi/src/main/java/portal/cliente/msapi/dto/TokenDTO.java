package portal.cliente.msapi.dto;

import lombok.Builder;

@Builder
public record TokenDTO(
        String token ,
        String role,
        Long timeout
) {
}
