
#!groovy
pipeline{
    stages{
        stage('deploy'){
            when {
                equals expected: true,actual: params.deploy
            }
		    steps{
			    script{
				    //echo "deploy jcreator"
                    //echo "pkg:${pkg['jcreator']}"
                    //curl -L -o jcreator.zip \"ipackage.jd.local/download_package?namespace=/search_v7/jcreator/packages&package=${pkg['jcreator']}\"
                    //sh "ssh $deploy_ip \"sudo supervisorctl stop jcreator\""
                    //sh "ssh $deploy_ip \"mkdir -p /export/Logs/jcreator/ && mkdir -p /App/jcreator/ && cd /App/jcreator/ && rm -rf *\""
                    //sh "scp -r jcreator.zip $deploy_ip:/App/jcreator/"
                    //sh "ssh $deploy_ip \"cd /App/jcreator/; unzip jcreator.zip\""
                    //sh "scp -r  ops_search/roles/jcreator/files/bin $deploy_ip:/App/jcreator/"
                    //sh "ssh $deploy_ip \"sudo supervisorctl start jcreator\""
                    sh "sh greensleeves/pipeline/new_architecture/deploy/deploy_jcreator.sh ${pkg['jcreator']} $deploy_ip"
                    sh "sh greensleeves/pipeline/new_architecture/deploy/check_start_by_info.sh ${deploy_ip} 7003"
                    health_res = sh returnStatus: true, script: "python run.py -r ../conf/searchv7_perf.ini -p ../conf/policy.ini -s ../conf/source.ini -m ../conf/mail.ini  -t 'jcreator health check'"
                    
            }
          }
        }
    }
}
