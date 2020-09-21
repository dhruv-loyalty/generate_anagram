/*resource "aws_alb" "main" {
  name            = "anagram-balancer"
  subnets         = [module.vpc-prod.public_subnets[0], module.vpc-prod.public_subnets[1], module.vpc-prod.public_subnets[2]]
  security_groups = [aws_security_group.lb.id]

}

resource "aws_alb_target_group" "app" {
  name        = "anagram-target-group"
  port        = 80
  protocol    = "HTTP"
  vpc_id      = module.vpc-prod.vpc_id
  target_type = "ip"


  health_check {
    healthy_threshold   = "3"
    interval            = "30"
    protocol            = "HTTP"
    matcher             = "200"
    timeout             = "3"
    path                = var.health_check_path
    unhealthy_threshold = "2"
  }
}

# Redirect all traffic from the ALB to the target group
resource "aws_alb_listener" "front_end" {
  load_balancer_arn = aws_alb.main.id
  port              = var.app_port
  protocol          = "HTTP"

  default_action {
    target_group_arn = aws_alb_target_group.app.id
    type             = "forward"
  }
}*/

module "main" {
  source  = "terraform-aws-modules/alb/aws"
  version = "~> 5.0"

  name = "anagram-balancer"

  load_balancer_type = "application"

  vpc_id             = module.vpc-prod.vpc_id
  subnets            = [module.vpc-prod.public_subnets[0], module.vpc-prod.public_subnets[1], module.vpc-prod.public_subnets[2]]
  security_groups    = ["sg-edcd9784", "sg-edcd9785"]

  access_logs = {
    bucket = "anagram-alb-logs"
  }

  target_groups = [
    {
     # name_prefix      = "pref-"
      backend_protocol = "HTTP"
      backend_port     = var.app_port
      target_type      = "instance"
    }
  ]

  https_listeners = [
    {
      port               = 443
      protocol           = "HTTPS"
      certificate_arn    = "arn:aws:iam::123456789012:server-certificate/test_cert-123456789012"
      target_group_index = 0
    }
  ]

  http_tcp_listeners = [
    {
      port               = 80
      protocol           = "HTTP"
      target_group_index = 0
    }
  ]

  tags = {
    Environment = "Test"
  }
}