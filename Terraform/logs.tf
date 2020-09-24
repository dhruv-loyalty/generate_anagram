resource "aws_cloudwatch_log_group" "anagram_log_group" {
  name              = "/ecs/anagrams"
  retention_in_days = 30

  tags = {
    Name = "anagram-log-group"
  }
}

resource "aws_cloudwatch_log_stream" "anagram_log_stream" {
  name           = "anagram-log-stream"
  log_group_name = aws_cloudwatch_log_group.anagram_log_group.name
}