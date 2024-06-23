package physiodesk.physiodesk_backend.iam.infrastructure.hashing.bcrypt;

import org.springframework.security.crypto.password.PasswordEncoder;
import physiodesk.physiodesk_backend.iam.application.internal.outboundservices.hashing.HashingService;

/**
 * This interface is a marker interface for the BCrypt hashing service.
 * It extends the {@link HashingService} and {@link PasswordEncoder} interfaces.
 * This interface is used to inject the BCrypt hashing service in the {@link com.acme.learning.platform.iam.infrastructure.hashing.bcrypt.services.HashingServiceImpl} class.
 */
public interface BCryptHashingService extends HashingService, PasswordEncoder {
}
