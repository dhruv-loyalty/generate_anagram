/*resource "aws_ecs_service" "anagram_service" {
  name            = "anagram_service"                             # Naming our first service
  cluster         = aws_ecs_cluster.anagram_cluster.id             # Referencing our created Cluster
  task_definition = aws_ecs_task_definition.anagram_task.arn # Referencing the task our service will spin up
  launch_type     = "FARGATE"
  desired_count   = 2 # Setting the number of containers we want deployed to 2
  depends_on = [aws_lb_listener.listener]

   load_balancer {
    target_group_arn = aws_lb_target_group.target_group.arn # Referencing our target group
    container_name   = aws_ecs_task_definition.anagram_task.family
    container_port   = 8080 # Specifying the container port
  }

  network_configuration {
    assign_public_ip = true # Providing our containers with public IPs
    subnets = [module.vpc-prod.public_subnets[0], module.vpc-prod.public_subnets[1], module.vpc-prod.public_subnets[2]]
  }
}

resource "aws_security_group" "service_security_group" {
  vpc_id      = module.vpc-prod.vpc_id
  ingress {
    from_port = 0
    to_port   = 0
    protocol  = "-1"
    # Only allowing traffic in from the load balancer security group
    security_groups = [aws_security_group.load_balancer_security_group.id]
  }

  egress {
    from_port   = 0 # Allowing any incoming port
    to_port     = 0 # Allowing any outgoing port
    protocol    = "-1" # Allowing any outgoing protocol
    cidr_blocks = ["0.0.0.0/0"] # Allowing traffic out to all IP addresses
  }
}*/