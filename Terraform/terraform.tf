terraform {
  backend "s3" {
    bucket = "dhruv-aws-bucket-2"
    key    = "terraform/terraform.tfstate"
    region = "us-east-1"
  }
}