package matching.dto;

import java.util.UUID;

public record Row(UUID grandParentUuid, Integer parentId, UUID fundingBucketUuid, Integer studentId, String studentType,
                  String currency, String studentName) {
}
